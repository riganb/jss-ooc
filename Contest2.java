import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;

public class Contest2 {

	public static void removeSpam(String folder) {

		// Your logic goes here

		ArrayList<String> spam = new ArrayList<>();
		spam.add("Null");
		spam.add("Unsubscribe");
		spam.add("Spam");
		spam.add("Reply");

		String content = "";
		File filesList[] = (new File(folder)).listFiles();

		for(File currentFile: filesList) {
			try {
				content = Files.readString(Paths.get(currentFile.getAbsolutePath()));
			
				for(String temp: spam)
					content = content.replace(temp, "");
				
				FileWriter fW = new FileWriter(currentFile);
				fW.write(content);
				fW.close();
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		String folder = "C:/notes";

		removeSpam(folder);
	}

}
