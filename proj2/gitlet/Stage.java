package gitlet;

import java.io.File;
import static gitlet.Utils.*;
import java.io.Serializable;
import java.util.*;

public class Stage implements Serializable{
    public String stageName;
    /** A mapping of file paths to blob id, where file paths is the key. */
    public Map<String, String> stageBlobMap = new TreeMap<>();
    public List<String> stageBlobID = new ArrayList<>();

    public Stage(String stageName) {
        this.stageName = stageName;
    }

    public void saveToFile() {
        File outfile = join(Repository.STAGE_FOLDER, this.stageName);
        writeObject(outfile, this);
    }

    public static Stage getFromFile(String stageName) {
        File infile = join(Repository.STAGE_FOLDER, stageName);
        return readObject(infile, Stage.class);
    }

}
