package p_lampu;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNamaLampu;
    @FXML
    private ComboBox<?> tfDaya;
    @FXML
    private DatePicker tfTanggal;
    @FXML
    private TextField tfBerat;
    @FXML
    private TableView<p_lampu> tvBooks;
    @FXML
    private TableColumn<p_lampu, Integer> colId;
    @FXML
    private TableColumn<p_lampu, String> colNamaLampu;
    @FXML
    private TableColumn<p_lampu, String> colDaya;
    @FXML
    private TableColumn<p_lampu, String> colTanggal;
    @FXML
    private TableColumn<p_lampu, String> colBerat;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
 
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         showBooks();
        ArrayList <String> list = new ArrayList<String>();
        list.add("5 Watt");
        list.add("8 Watt");
        list.add("11 Watt");
        list.add("15 Watt");
        list.add("18 Watt");
        list.add("23 Watt");
        ObservableList items = FXCollections.observableArrayList(list);
        tfDaya.setItems(items);
    }    
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lampu", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<p_lampu> getBooksList(){
        ObservableList<p_lampu> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM lampu";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            p_lampu kursi;
            while(rs.next()){
                kursi = new p_lampu(rs.getInt("id"), rs.getString("nama_lampu"), rs.getString("daya"), rs.getString("tanggal"),rs.getInt("berat"));
                bookList.add(kursi);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookList;
    }
    
    public void showBooks(){
        ObservableList<p_lampu> list = getBooksList();
        
        colId.setCellValueFactory(new PropertyValueFactory<p_lampu, Integer>("id"));
        colNamaLampu.setCellValueFactory(new PropertyValueFactory<p_lampu, String>("nama_lampu"));
        colDaya.setCellValueFactory(new PropertyValueFactory<p_lampu, String>("daya"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<p_lampu, String>("tanggal"));
        colBerat.setCellValueFactory(new PropertyValueFactory<p_lampu, String>("berat"));
        
        tvBooks.setItems(list);
    }
    
    private void insertRecord(){
        String query = "INSERT INTO lampu VALUES (" + tfId.getText() + ",'" + tfNamaLampu.getText() + "','" + tfDaya.getValue().toString() + "',"
                + tfTanggal.getValue().toString() + "," + tfBerat.getText() + ")";
        executeQuery(query);
        showBooks();
    }
    
    private void updateRecord(){
        String query = "UPDATE  lampu SET nama_lampu  = '" + tfNamaLampu.getText() + "', daya = '" + tfDaya.getValue().toString() + "', tanggal = " +
                tfTanggal.getValue().toString() + ", berat = " + tfBerat.getText() + " WHERE id = " + tfId.getText() + "";
        executeQuery(query);
        showBooks();
    }
    
    private void deleteButton(){
        String query = "DELETE FROM lampu WHERE id =" + tfId.getText() + "";
        executeQuery(query);
        showBooks();
    }
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
