import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleFrequencyAnalysis {

    private static final String FILENAME = "patch_to_file";

    public static void main(String[] args) {
        
        char alphabet[] = new char[64]; // testable alphabet
		int  index[] = new int[64]; // letter frequency indexing
		float dolya[] = new float[64]; // distribution
		char buf = 'А'; // buffer containing an element of the alphabet
		int data=0; 
		int i=0;
		int j=0;
		while (buf <= 'я') {
			
			alphabet[i] = buf;
			//index[0][i] = i;
			i++;
			buf++;
		}
        
        
        
        try {
            final BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(FILENAME), "UTF8"));
            
            String nextString;
            while ((nextString = br.readLine()) != null) {
				
				char[] chArray = nextString.toCharArray();
				
				for(i=0; i<chArray.length;i++){
			
					for(j=0; j<=63; j++){
					
						if ( alphabet[j] ==  chArray[i]) {
					
						index[j]+=1;
						data+=1;
						} else continue;
					}
				}
            }	
        
			for(i=0; i<index.length;i++) {
			
				dolya[i] = (float)index[i] / data;
				
				System.out.print( alphabet[i] + "\t");
				System.out.print(index[i] + "\t");
				System.out.println(dolya[i] + "\t ");
			}
        
			System.out.println("Количество символов: " + data);
        
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(SimpleFrequencyAnalysis.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleFrequencyAnalysis.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
// usage:  javac SimpleFrequencyAnalysis.java && java SimpleFrequencyAnalysis
