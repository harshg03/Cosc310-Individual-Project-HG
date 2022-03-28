import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public class ReadFromFile {
	// this class is used for reading values from a text file into a HashMap using specified delimiter
	public static void main(String[] args) throws IOException {
		
		System.out.println(txtToMap("./responses.txt","]"));
		
	}
	
	public static HashMap<String, String> txtToMap(String path,String delimiter) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        try(Stream<String> lines = Files.lines(Paths.get(path))){
            lines.filter(line -> line.contains(delimiter)).forEach(
                line -> map.putIfAbsent(line.split(delimiter)[0], line.split(delimiter)[1])
            );
        }

        return map;
        
    }

}
