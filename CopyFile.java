import java.io.*;
import java.lang.*;

public class CopyFile
{
    public static void main(String[] args) throws IOException {

        File xmlFile = new File("oldXMLFile.xml");
        BufferedReader br = new BufferedReader(new FileReader(xmlFile));
        String newline = System.getProperty("line.separator");
        String line = null;
        StringBuffer sb =  new StringBuffer();
        while((line = br.readLine())!= null)
        {
            if(line.indexOf("&#xD") != -1)
            {
                line = line.replaceAll("&#xD","<");
            }
            if(line.indexOf("&lt") != -1){
                line = line.replaceAll("&lt",">");
            }
            sb.append(line).append(newline);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(xmlFile));
        bw.write(sb.toString());
        bw.close();
    }
}