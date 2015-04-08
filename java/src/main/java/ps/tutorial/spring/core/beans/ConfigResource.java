package ps.tutorial.spring.core.beans;

import org.springframework.core.io.Resource;

import java.io.*;

public class ConfigResource {

    Resource config;

    public ConfigResource(Resource config) {
        this.config = config;
    }

    @Override
    public String toString() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(config.getFile()));
            StringWriter out = new StringWriter();
            String line;
            while ((line = in.readLine()) != null)
                out.write(line + "/n");
            return out.toString();
        } catch (IOException e) {
            return "empty";
        }
    }
}
