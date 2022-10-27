import java.io.*;

public class FileUtility {


    private static void write(String fileName,String text, boolean append) throws IOException {

        try(  FileWriter fw = new FileWriter(fileName,append);
              BufferedWriter bw = new BufferedWriter(fw);
              ) {
            bw.write(text);
        }
    }

    public static void writeToFile(String fileName, String text)throws Exception{
        write(fileName,text,false);
    }
    public static void writeInToFile(String fileName, String text)throws Exception{
        write(fileName,text,true);
    }
    public static void writeIntoFileByte(String filename, byte[] data) throws Exception{
        FileOutputStream fo = new FileOutputStream(filename);

        fo.write(data);
        fo.flush();;
        fo.close();

    }

    public static String read(String fileName) throws Exception{
        try (InputStream in = new FileInputStream(fileName);
             InputStreamReader ir = new InputStreamReader(in);
             BufferedReader reader = new BufferedReader(ir);){

            String line = reader.readLine();
            String result = "";

            while(line != null){
                result += line + "\n";
                line = reader.readLine();
            }
            return result;
        }
    }
    public static byte[] readWithBytes(String fileName) throws Exception{
        File file = new File(fileName);

        try ( FileInputStream in = new FileInputStream(file);){
            byte[] data = new byte[(int) file.length()];

            in.read(data);
            return data;
        }
    }

    public static void writeObjectToFile(Serializable object,String fileName) throws Exception{
       try ( FileOutputStream fop = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fop);
             ){
           oos.writeObject(object);
       }
    }

    public static Object readObjectFile(String fileName) throws Exception{
        Object obj = null;
        try(
                FileInputStream fil = new FileInputStream(fileName);
                ObjectInputStream oi = new ObjectInputStream(fil);
                ){
            obj = oi.readObject();
        }finally {
            return obj;
        }
    }
}
