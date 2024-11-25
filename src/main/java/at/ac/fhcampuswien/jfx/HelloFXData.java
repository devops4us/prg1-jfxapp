package at.ac.fhcampuswien.jfx;

import java.io.*;
import java.net.URI;
import java.net.URL;

/**
 * Class for saving and loading of persistent application data.
 * An instance of this class is saved as serialized java object in
 * binary format in a single file. A HelloFXData object can be created given
 * a valid file path. 
 */

public class HelloFXData implements Serializable
{
    static final long serialVersionUID = 1L;

    private transient String dataFileLocation;
    private String statusData;
    private String messageData;
    private String upTimeData;
    private String statusImageLocation;
    private String messageImageLocation;

    public String getStatusImageLocation() {
        return statusImageLocation;
    }
    public String getStatusImageLocationURL() throws Exception {
        return new File(statusImageLocation).toURL().toString();
    }
    public void setStatusImageLocation(String statusImageLocation) {
        this.statusImageLocation = statusImageLocation;
    }

    public String getMessageImageLocation() {
        return messageImageLocation;
    }
    public String getMessageImageLocationURL() throws Exception {
        return new File(messageImageLocation).toURL().toString();
    }


    public void setMessageImageLocation(String messageImageLocation) {
        this.messageImageLocation = messageImageLocation;
    }

    public String getStatusData() {
        return statusData;
    }

    public void setStatusData(String statusData) {
        this.statusData = statusData;
    }

    public String getMessageData() {
        return messageData;
    }

    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }

    public String getUpTimeData() {
        return upTimeData;
    }

    public void setUpTimeData(String upTimeData) {
        this.upTimeData = upTimeData;
    }

    public String getDataFileLocation() {
        return dataFileLocation;
    }

    public void setDataFileLocation(String dataFileLocation) {
        this.dataFileLocation = dataFileLocation;
    }

    public HelloFXData() {
        this.statusData="UP";
    }

    public HelloFXData(String dataFileLocation){
        this.dataFileLocation = dataFileLocation;
    }

    public static HelloFXData load(String dataFileLocation) throws Exception {
        File f= new File(dataFileLocation);
        if(!f.exists()) {
            return new HelloFXData(dataFileLocation);
        }
        ObjectInputStream in= new ObjectInputStream(new FileInputStream(f));
        HelloFXData data = (HelloFXData)in.readObject();
        data.setDataFileLocation(dataFileLocation);
        return data;
    }

    public void save() throws Exception {
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(dataFileLocation));
        out.writeObject(this);
    }
}
