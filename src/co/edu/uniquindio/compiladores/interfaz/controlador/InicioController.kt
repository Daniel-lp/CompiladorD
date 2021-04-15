package co.edu.uniquindio.compiladores.interfaz.controlador

import co.edu.uniquindio.compiladores.logica.lexico.AnalizadorLexico
import co.edu.uniquindio.compiladores.logica.lexico.Error
import co.edu.uniquindio.compiladores.logica.lexico.Token
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import java.net.URL
import java.util.*



/*
    @Autor:Daniel Loaiza Diego Diaz
 */
class InicioController: Initializable {

    @FXML lateinit var codigoFuente: TextArea
    @FXML lateinit var tablaTokens: TableView<Token>
    @FXML lateinit var tablaErroresLexico: TableView<Error>
    @FXML lateinit var colLexema: TableColumn<Token, String>
    @FXML lateinit var colCategoria: TableColumn<Token, String>
    @FXML lateinit var colFila: TableColumn<Token, String>
    @FXML lateinit var colColumna: TableColumn<Token, String>
    @FXML lateinit var colMensajeErrorLexico: TableColumn<Error, String>
    @FXML lateinit var colFilaErrorLexico: TableColumn<Error, String>
    @FXML lateinit var colColumnaErrorLexico: TableColumn<Error, String>
    @FXML lateinit var arbolVisual:TreeView<String>
    @FXML lateinit var txtJavaCodigo: TextArea

    lateinit var lexico: AnalizadorLexico


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        colLexema.cellValueFactory = PropertyValueFactory("lexema")
        colCategoria.cellValueFactory = PropertyValueFactory("categoria")
        colFila.cellValueFactory = PropertyValueFactory("fila")
        colColumna.cellValueFactory = PropertyValueFactory("columna")
        colMensajeErrorLexico.cellValueFactory = PropertyValueFactory("error")
        colFilaErrorLexico.cellValueFactory = PropertyValueFactory("fila")
        colColumnaErrorLexico.cellValueFactory = PropertyValueFactory("columna")

    }

    fun AnalizarCodigo ( e: ActionEvent) {

        if (codigoFuente.text.length > 0) {
            lexico = AnalizadorLexico(codigoFuente.text)
            lexico.analizar()
            tablaTokens.items = FXCollections.observableArrayList(lexico.listaTokens)
            tablaErroresLexico.items = FXCollections.observableArrayList(lexico.listaErrores)
        }else {
            var alerta = Alert(Alert.AlertType.WARNING)
            alerta.headerText = "CUIDADO"
            alerta.contentText = "No hay codigo fuente"
            alerta.show()
        }
    }
    fun limpiar(e: ActionEvent) {
        tablaTokens.items.clear()
        tablaErroresLexico.items.clear()
        txtJavaCodigo.clear()
        codigoFuente.clear()
    }

}