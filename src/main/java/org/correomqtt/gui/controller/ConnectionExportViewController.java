package org.correomqtt.gui.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.correomqtt.business.dispatcher.ConfigDispatcher;
import org.correomqtt.business.dispatcher.ConnectionLifecycleDispatcher;
import org.correomqtt.business.keyring.KeyringFactory;
import org.correomqtt.business.model.*;
import org.correomqtt.business.provider.SettingsProvider;
import org.correomqtt.gui.cell.GenericCell;
import org.correomqtt.gui.helper.CheckTopicHelper;
import org.correomqtt.gui.model.ConnectionPropertiesDTO;
import org.correomqtt.gui.model.WindowProperty;
import org.correomqtt.gui.model.WindowType;
import org.correomqtt.gui.utils.WindowHelper;
import org.correomqtt.plugin.manager.PluginManager;
import org.correomqtt.plugin.spi.LwtSettingsHook;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ConnectionExportViewController  extends BaseController {

    private final ConnectionExportViewDelegate delegate;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionExportViewController.class);


    @FXML
    private ListView<ConnectionPropertiesDTO> connectionsListView;
    @FXML
    private Button exportButton;
    @FXML
    private AnchorPane containerAnchorPane;

    private ConnectionPropertiesDTO activeConnectionConfigDTO;

    private static ResourceBundle resources;


    public ConnectionExportViewController(ConnectionExportViewDelegate delegate) {
        this.delegate = delegate;

    }

    public static LoaderResult<ConnectionExportViewController> load(ConnectionExportViewDelegate delegate) {
        return load(ConnectionExportViewController.class, "connectionExportView.fxml",
                () -> new ConnectionExportViewController(delegate));
    }

    public static void showAsDialog(ConnectionExportViewDelegate delegate) {

        LOGGER.info("OPEN DIALOG");
        Map<Object, Object> properties = new HashMap<>();
        properties.put(WindowProperty.WINDOW_TYPE, WindowType.CONNECTION_EXPORT);

        if (WindowHelper.focusWindowIfAlreadyThere(properties)) {
            return;
        }
        LoaderResult<ConnectionExportViewController> result = load(delegate);
        resources = result.getResourceBundle();

        showAsDialog(result, resources.getString("connectionExportViewControllerTitle"), properties, false, false, null,
                event -> result.getController().keyHandling(event));
    }


    @FXML
    public void initialize() {

        containerAnchorPane.getStyleClass().add(SettingsProvider.getInstance().getIconModeCssClass());


    }

    private void keyHandling(KeyEvent event) {
        if (KeyCode.ESCAPE == event.getCode()) {
            closeDialog();
        }
    }

    private void closeDialog() {
        Stage stage = (Stage) exportButton.getScene().getWindow();
        stage.close();
    }

}
