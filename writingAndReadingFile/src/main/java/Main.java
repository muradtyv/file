public class Main {

    public static void main(String[] args) throws Exception{
//        FileUtility.writeInToFile("test.txt", "  new text");

//        FileUtility.writeIntoFileByte("alma.txt","Murad bytes".getBytes());

//        System.out.println(FileUtility.read("alma.txt"));

//        byte[] bytes =FileUtility.readWithBytes("Image 11.jpg");

//        FileUtility.writeIntoFileByte("photo.jpg", bytes);

        User user =(User) FileUtility.readObjectFile("object.obj");
        System.out.println(user.name);

//        FileUtility.writeObjectToFile(user, "object.obj");
    }
}
