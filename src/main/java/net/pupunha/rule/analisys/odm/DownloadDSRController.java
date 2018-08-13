package net.pupunha.rule.analisys.odm;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import de.jensd.fx.glyphs.GlyphsBuilder;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DownloadDSRController implements Initializable {

    private static final String EM1 = "1em";
    private static final String ERROR = "error";

    @FXML
    private JFXTextField txtServer;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnConnect;

    @FXML
    private JFXComboBox<String> ruleapp;

    @FXML
    private JFXComboBox<String> ruleappVersion;

    @FXML
    private JFXComboBox<String> ruleset;

    @FXML
    private JFXComboBox<String> rulesetVersion;

    private ODMServer odmServer;

    public DownloadDSRController() {
        odmServer = new ODMServer();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        txtServer.requestFocus();

        btnConnect.getStyleClass().add("button-raised");

        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");
        validator.setIcon(GlyphsBuilder.create(FontAwesomeIconView.class)
                .glyph(FontAwesomeIcon.WARNING)
                .size(EM1)
                .styleClass(ERROR)
                .build());

        txtServer.getValidators().add(validator);
        txtServer.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtServer.validate();
            }
        });

        txtUsername.getValidators().add(validator);
        txtUsername.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtUsername.validate();
            }
        });

        txtPassword.getValidators().add(validator);
        txtPassword.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtPassword.validate();
            }
        });

    }

    @FXML
    private void handleActionConnect(ActionEvent event) {
        if(txtServer.validate() && txtUsername.validate() && txtPassword.validate()) {
            List ruleApp = odmServer.getRuleApps(txtServer.getText(), txtUsername.getText(), txtPassword.getText());

        }
    }

}
