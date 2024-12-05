package at.ac.fhcampuswien.jfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.ByteArrayInputStream;

/**
 * JFX Controller for HelloFX Application. The controller holds all the dynamic
 * user interface elements and implements the logic needed to react to user events.
 * JFX Controller ist created by the JFX runtime when the hellofx.fxml file is loaded.
 */

public class HelloFXController implements EventHandler<ActionEvent>
{
    static final String TIME_FORMAT="hh:mm:ss";
    static final String DATA_FILE_LOCATION="data/hellofx.dat";

    private HelloFXData data;
    private Timer timer;

    @FXML
    private Text status;
    @FXML
    private ImageView statusImage;
    @FXML
    private Text uptime;
    @FXML
    private TextArea message;
    @FXML
    private ImageView messageImage;



    @FXML
    public void initialize() throws Exception
    {
        data= HelloFXData.load(DATA_FILE_LOCATION);
        if(data.getStatusImageLocation()!=null) {
            this.statusImage.setImage(new Image(data.getStatusImageLocationURL()));
        }
        this.status.setText(data.getStatusData());
        if(data.getMessageData()!=null) {
            this.messageImage.setImage(new Image(data.getMessageImageLocationURL()));
        }
        this.message.setText(data.getMessageData());
        this.uptime.setText(data.getUpTimeData());

        this.timer= new Timer(data.getUpTimeData(),this);
        timer.start();
    }


    @FXML
    private void handleSendMessageClick() {
        message.appendText("\n ===== \n Nachricht gesendet \n");
    }

    public void stop() throws Exception{
        data.setMessageData(message.getText());
        data.setStatusData(status.getText());
        data.setUpTimeData(uptime.getText());
        data.save();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
            this.timer.updateTime();
            this.uptime.setText(this.timer.getTimeAsString());
    }
}
