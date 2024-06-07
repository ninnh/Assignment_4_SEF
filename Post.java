import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postType;
    private String postEmergency;
    private List<String> postComments = new ArrayList<>();

    private final String[] validPostTypes = {"Very Difficult", "Difficult", "Easy"};
    private final String[] validPostEmergency = {"Immediately Needed", "Highly Needed", "Ordinary"};

    public Post(int postID, String postTitle, String postBody, String[] postTags, String postType, String postEmergency) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postTags = postTags;
        this.postType = postType;
        this.postEmergency = postEmergency;
    }

    public String addPost() {
        // Condition 1: Post title length and first 5 characters are letters
        if (postTitle.length() < 10 || postTitle.length() > 250 || !postTitle.substring(0, 5).matches("[a-zA-Z]+")) {
            System.out.println("Condition 1 failed");
            return "The post information cannot be added";
        }

        // Condition 2: Post body length
        if (postBody.length() < 250) {
            System.out.println("Condition 2 failed");
            return "The post information cannot be added";
        }

        // Condition 3: Post tags
        if (postTags.length < 2 || postTags.length > 5) {
            System.out.println("Condition 3 failed - tag count");
            return "The post information cannot be added";
        }
        for (String tag : postTags) {
            if (tag.length() < 2 || tag.length() > 10 || !tag.equals(tag.toLowerCase())) {
                System.out.println("Condition 3 failed - invalid tag: " + tag);
                return "The post information cannot be added";
            }
        }

        // Condition 4: Post type and body length
        if (!Arrays.asList(validPostTypes).contains(postType)) {
            System.out.println("Condition 4 failed - invalid post type: " + postType);
            return "The post information cannot be added";
        }
        if (postType.equals("Easy") && postTags.length > 3) {
            System.out.println("Condition 4 failed - too many tags for Easy post");
            return "The post information cannot be added";
        }
        if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postBody.length() < 300) {
            System.out.println("Condition 4 failed - post body too short for Difficult post");
            return "The post information cannot be added";
        }

        // Condition 5: Post emergency
        if (!Arrays.asList(validPostEmergency).contains(postEmergency)) {
            System.out.println("Condition 5 failed - invalid post emergency: " + postEmergency);
            return "The post information cannot be added";
        }
        if (postType.equals("Easy") && (postEmergency.equals("Immediately Needed") || postEmergency.equals("Highly Needed"))) {
            System.out.println("Condition 5 failed - invalid emergency for Easy post");
            return "The post information cannot be added";
        }
        if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postEmergency.equals("Ordinary")) {
            System.out.println("Condition 5 failed - invalid emergency for Difficult post");
            return "The post information cannot be added";
        }

        // If all conditions are met, write to the file
        try (FileWriter writer = new FileWriter("posts.txt", true)) {
            writer.write("PostID: " + postID + "\n");
            writer.write("Title: " + postTitle + "\n");
            writer.write("Body: " + postBody + "\n");
            writer.write("Tags: " + String.join(", ", postTags) + "\n");
            writer.write("Type: " + postType + "\n");
            writer.write("Emergency: " + postEmergency + "\n");
            writer.write("----\n");
        } catch (IOException e) {
            e.printStackTrace();
            return "The post information cannot be added";
        }

        return "The post information can be added";
    }

    public String addComment(String comment) {
        // Condition 1
        String[] words = comment.split(" ");
        if (words.length < 4 || words.length > 10 || !Character.isUpperCase(words[0].charAt(0))) {
            System.out.println("Condition 1 for comment failed");
            return "The comment cannot be added";
        }

        // Retrieve existing comments
        List<String> allComments = new ArrayList<>();
        try {
            allComments = Files.readAllLines(Paths.get("comments.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Condition 2
        long commentCount = allComments.stream().filter(line -> line.contains("PostID: " + postID)).count();
        if (commentCount >= 5) {
            System.out.println("Condition 2 for comment failed - too many comments");
            return "The comment cannot be added";
        }
        if (postType.equals("Easy") && commentCount >= 3) {
            System.out.println("Condition 2 for comment failed - too many comments for Easy post");
            return "The comment cannot be added";
        }
        if (postEmergency.equals("Ordinary") && commentCount >= 3) {
            System.out.println("Condition 2 for comment failed - too many comments for Ordinary post");
            return "The comment cannot be added";
        }

        // If all conditions are met, write to the file and add to the list
        try (FileWriter writer = new FileWriter("comments.txt", true)) {
            writer.write("PostID: " + postID + " - Comment: " + comment + "\n");
            writer.write("----\n");
        } catch (IOException e) {
            e.printStackTrace();
            return "The comment cannot be added";
        }

        postComments.add(comment);
        return "The comment can be added";
    }
}
