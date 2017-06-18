package net.springland.java8inaction.chapter1;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.logging.Logger;

/**
 * Created by fl on 6/17/2017.
 */


public class FileFilterTest {

    public static Logger  logger = Logger.getLogger(FileFilterTest.class.getName());
    @Test
    public void testListDirectoryFilterClass()
    {
        File[]  directories = new File(".").listFiles( new FileFilter()
        {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for(File dir: directories)
        {
            logger.info("directory :"+dir.getAbsolutePath());
        }


    }

    @Test
    public  void testListDirectoryFilterJava8()
    {
        File[] directories = new File(".").listFiles(File::isDirectory);
        for(File dir: directories)
        {
            logger.info("directory :"+dir.getAbsolutePath());
        }


    }


}
