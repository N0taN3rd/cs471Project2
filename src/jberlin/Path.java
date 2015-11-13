package jberlin;

/**
 * Created by jberlin on 11/12/2015.
 */
public class Path {
    private String drive;
    private String folder;

    public Path(String drive, String folder) {
        this.drive = drive;
        this.folder = folder;
    }

    public String getRealPath(){
        return drive+":~/"+folder;
    }

    public String getVFSPath(){
        return "~/"+folder;
    }

    public String getDrive() {
        return drive;
    }

    public String getFolder() {
        return folder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Path)) return false;

        Path path = (Path) o;

        if (drive != null ? !drive.equals(path.drive) : path.drive != null) return false;
        return !(folder != null ? !folder.equals(path.folder) : path.folder != null);

    }

    @Override
    public int hashCode() {
        int result = drive != null ? drive.hashCode() : 0;
        result = 31 * result + (folder != null ? folder.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Path{" +
                "drive='" + drive + '\'' +
                ", folder='" + folder + '\'' +
                '}';
    }
}
