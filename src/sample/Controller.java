package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;

public class Controller {

    private Stage root;

    @FXML private TextField selectedPath;
    @FXML private Button btnStart;
    @FXML private TextArea txtArea;

    Extensions extensions = new Extensions();

    String[] doc = extensions.getDocs();
    String[] compressed = extensions.getCompressed();
    String[] exe    = extensions.getExes();
    String[] audio  = extensions.getAudios();
    String[] video  = extensions.getVideos();
    String[] image  = extensions.getImages();

    private int videoCount = 0, docCount = 0, audioCount = 0, imageCount = 0, exeCount = 0, compressedCount = 0, otherCount = 0, totalCount = 0;

    private void filterFiles(String dirStr) throws Exception {
        File dir = new File(dirStr);

        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                txtArea.appendText(f.getName() + "\n");
                String extension = getExtension(f.getName());
                File newDir = null;

                if (contains(video, extension)) {
                    newDir = new File(dirStr + "/Videos");
                    videoCount++;
                } else if (contains(audio, extension)) {
                    newDir = new File(dirStr + "/Audio");
                    audioCount++;
                } else if (contains(exe, extension)) {
                    newDir = new File(dirStr + "/Programs");
                    exeCount++;
                } else if (contains(image, extension)) {
                    newDir = new File(dirStr + "/Images");
                    imageCount++;
                } else if (contains(compressed, extension)) {
                    newDir = new File(dirStr + "/Compressed");
                    compressedCount++;
                } else if (contains(doc, extension)) {
                    newDir = new File(dirStr + "/Documents");
                    docCount++;
                } else {
                    newDir = new File(dirStr + "/Others");
                    otherCount++;
                }

                newDir.mkdir();

                URI moveTo = new File(newDir.getAbsolutePath() + "/" + f.getName()).toURI();
                Files.move(Paths.get(f.toURI()), Paths.get(moveTo), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    private boolean contains(String[] arr, String extension) {
        for (String e : arr) {
            if (e.toLowerCase().equals(extension.toLowerCase()))
                return true;
        }
        return false;
    }

    private String getExtension(String filename) {
        String[] exts = filename.split("\\.");
        return exts[exts.length-1];
    }

    public void browseFolder(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose directory");

        File file = chooser.showDialog(this.root);

        if (file != null) {
            selectedPath.setText(file.getAbsolutePath());
            btnStart.setDisable(false);
        }
    }

    public void startOrganiser(ActionEvent actionEvent) {
        if (!selectedPath.getText().isEmpty()) {
            btnStart.setDisable(true);
            btnStart.setText("Organising...");

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                filterFiles(selectedPath.getText());
                                totalCount = audioCount + videoCount + exeCount + docCount + compressedCount + imageCount + otherCount;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            txtArea.appendText("\nDONE\nFound " + totalCount + " files (" + exeCount + " Executables, " + docCount + " Documents, " + videoCount + " Videos, " + audioCount + " Audios, " +
                                    imageCount + " Images, " + compressedCount + " Compressed, " + otherCount + " Other)\n\n");
                            txtArea.selectPositionCaret(txtArea.getLength());

                            btnStart.setText("Start organising");
                            selectedPath.setText("");
                        }
                    });
                }
            });

            t.setDaemon(true);
            t.start();

        }
    }

    public void setStage(Stage primaryStage) {
        this.root = primaryStage;
    }
}
