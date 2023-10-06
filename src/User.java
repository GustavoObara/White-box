import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// Notação Grafo de Fluxo
public class User {
    /*3*/public Connection conectarBD() {
        /*4*/Connection conn = null;
        /*5*/try{
            /*5*/Class.forName("com.mysql.Driver.Manager").newInstance();
            /*5*/String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            /*5*/conn = DriverManager.getConnection(url);
        }/*7*/catch (Exception e) { }
        /*6*/return conn; }
    public String nome="";
    public boolean result = false;
    public boolean verificarUsuario(String login, String senha) {
        /*1*/String sql = "";
        /*2*/Connection conn = conectarBD();
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "'"; /*8*/
        /*9*/try{
            /*9*/Statement st = conn.createStatement();
            /*9*/ResultSet rs = st.executeQuery(sql);
            /*10*/if (rs.next()) {
                /*11*/result = true;
                /*11*/nome = rs.getString("nome"); }
        } /*12*/catch (Exception e) { }
        /*13*/return result;}
}