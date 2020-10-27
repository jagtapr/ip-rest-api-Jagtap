import java.io.*;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScriptPython {
       Process mProcess;

public void runScript(){
       Process process;
       try{
             process = Runtime.getRuntime().exec(new String[]{"python run.py","arg1","arg2"});
             mProcess = process;
       }catch(Exception e) {
          System.out.println("Error Raised" + e.toString());
       }
       InputStream stdout = mProcess.getInputStream();
       BufferedReader reader = new BufferedReader(new InputStreamReader(stdout,StandardCharsets.UTF_8));
       String line;
       try{
          while((line = reader.readLine()) != null){
               System.out.println("stdout: "+ line);
          }
       }catch(IOException e){
             System.out.println("Error in reading output"+ e.toString());
       }
}
}

class Solution {
      public static void main(String[] args){
          ScriptPython scriptPython = new ScriptPython();
          scriptPython.runScript();
      }

}
