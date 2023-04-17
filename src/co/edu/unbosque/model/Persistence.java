package co.edu.unbosque.model;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Persistence {

    Properties properties = new Properties(null);

    try
    {
        properties.load(new FileInputStream(new File("Configuracion properties")));
    }catch(
    FileNotFoundException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }catch(
    IOException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
