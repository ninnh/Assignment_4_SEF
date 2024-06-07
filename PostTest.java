import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    void testAddPost() {
        // Test Case 1: Valid Post
            // Test Data 1a
        String[] tags1 = {"tag1", "tag2"};
        Post post1 = new Post(1, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags1, "Difficult", "Highly Needed");
        assertEquals("The post information can be added", post1.addPost());
            // Test Data 1b
        String[] tags1b = {"tag1", "tag2", "tag3"};
        Post post1b = new Post(1, "StillValidTitle", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags1b, "Very Difficult", "Highly Needed");
        assertEquals("The post information can be added", post1b.addPost());

        // Test Case 2: Invalid Post Title
            // Test Data 2a
        String[] tags2 = {"tag1", "tag2"};
        Post post2 = new Post(2, "12345Invalid", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags2, "Difficult", "Highly Needed");
        assertEquals("The post information cannot be added", post2.addPost());
            // Test Data 2b
        Post post2b = new Post(2, "Inval", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags2, "Difficult", "Highly Needed");
        assertEquals("The post information cannot be added", post2b.addPost());

        // Test Case 3: Invalid Post Body
            // Test Data 3a
        String[] tags3 = {"tag1", "tag2"};
        Post post3 = new Post(3, "ValidTitle123", "Short body", tags3, "Difficult", "Highly Needed");
        assertEquals("The post information cannot be added", post3.addPost());
            // Test Data 3b
        Post post3b = new Post(3, "ValidTitle123", "Another short body", tags3, "Very Difficult", "Highly Needed");
        assertEquals("The post information cannot be added", post3b.addPost());

        // Test Case 4: Invalid Tags
            // Test Data 4a
        String[] tags4 = {"tag1", "tag2", "UPPERCASE"};
        Post post4 = new Post(4, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags4, "Difficult", "Highly Needed");
        assertEquals("The post information cannot be added", post4.addPost());
            // Test Data 4b
        String[] tags4b = {"tag1", "toolongtag123"};
        Post post4b = new Post(4, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags4b, "Difficult", "Highly Needed");
        assertEquals("The post information cannot be added", post4b.addPost());

        // Test Case 5: Invalid Post Type and Emergency
            // Test Data 5a
        String[] tags5 = {"tag1", "tag2"};
        Post post5 = new Post(5, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags5, "Easy", "Immediately Needed");
        assertEquals("The post information cannot be added", post5.addPost());
            // Test Data 5b
        Post post5b = new Post(5, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags5, "Easy", "Highly Needed");
        assertEquals("The post information cannot be added", post5b.addPost());

        // Test Case 6: Too Many Tags for Easy Post
            // Test Data 6a
        String[] tags6 = {"tag1", "tag2", "tag3", "tag4"};
        Post post6 = new Post(6, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags6, "Easy", "Ordinary");
        assertEquals("The post information cannot be added", post6.addPost());
            // Test Data 6b
        String[] tags6b = {"tag1", "tag2", "tag3", "tag4", "tag5"};
        Post post6b = new Post(6, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags6b, "Easy", "Ordinary");
        assertEquals("The post information cannot be added", post6b.addPost());
    }

    @Test
    void testAddComment() {
        // Setup Post
        String[] tags = {"tag1", "tag2"};
        Post post = new Post(1, "ValidTitle123", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags, "Difficult", "Highly Needed");
        assertEquals("The post information can be added", post.addPost());

        // Test Case 1: Valid Comment
            // Test Data 1a
        assertEquals("The comment can be added", post.addComment("This is a valid comment"));
            // Test Data 1b
        assertEquals("The comment can be added", post.addComment("Here is another valid comment"));

        // Test Case 2: Invalid Comment (Too Short)
            // Test Data 2a
        assertEquals("The comment cannot be added", post.addComment("Short"));
            // Test Data 2b
        assertEquals("The comment cannot be added", post.addComment("No"));

        // Test Case 3: Invalid Comment (Too Long)
            // Test Data 3a
        assertEquals("The comment cannot be added", post.addComment("This comment has more than ten words in it which makes it invalid"));
            // Test Data 3b
        assertEquals("The comment cannot be added", post.addComment("This is yet another comment that is way too long and should not be accepted"));

        // Test Case 4: Invalid Comment (No Uppercase First Letter)
            // Test Data 4a
        assertEquals("The comment cannot be added", post.addComment("this comment does not start with an uppercase letter"));
            // Test Data 4b
        assertEquals("The comment cannot be added", post.addComment("no uppercase first letter here either"));

        // Test Case 5: Valid Comment, but Too Many Comments
            // Test Data 5a
        post.addComment("A valid comment one");
        post.addComment("A Valid comment two");
        post.addComment("A Valid comment three");
        assertEquals("The comment cannot be added", post.addComment("A Valid comment four"));
            //Test Data 5b
        assertEquals("The comment cannot be added", post.addComment("A Valid comment five"));

        // Test Case 6: Valid Comment, but Too Many Comments for Ordinary Post
            // Test Data 6a
        Post ordinaryPost = new Post(2, "YetAnotherValidTitle", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate.", tags, "Difficult", "Ordinary");
        ordinaryPost.addComment("A Valid comment one");
        ordinaryPost.addComment("A Valid comment two");
        ordinaryPost.addComment("A Valid comment three");
        assertEquals("The comment cannot be added", ordinaryPost.addComment("A Valid comment four"));
            // Test Data 6b
        assertEquals("The comment cannot be added", ordinaryPost.addComment("A Valid comment five"));
    }
}
