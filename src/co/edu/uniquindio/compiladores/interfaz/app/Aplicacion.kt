package co.edu.uniquindio.compiladores.interfaz.app
import co.edu.uniquindio.compiladores.interfaz.controlador.InicioController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/*
    @Autor: Daniel Loaiza Y Diego Diaz
 */
class  Aplicacion : Application() {

    override fun start(primaryStage: Stage?) {
        println(Aplicacion::class.java.getResource("/Inicio.fxml"))
        val loader = FXMLLoader(Aplicacion::class.java.getResource("/Inicio.fxml"))
        val parent: Parent = loader.load()
        val scene = Scene(parent)

        primaryStage?.scene = scene
        primaryStage?.title = "Compilador DD"
        primaryStage?.show()
    }
    companion object{
        @JvmStatic
        fun main( args: Array<String>){
            launch(Aplicacion::class.java)

        }

    }

}