import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Classe que representa um usuário e fornece métodos para conexão ao banco de dados
 * e verificação de credenciais de login.
 */
public class User {
    /**
     * Método para conectar ao banco de dados.
     *
     * @return Uma conexão com o banco de dados, ou null em caso de falha na conexão.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) { }
        return conn; }
    public String nome="";
    public boolean result = false;
    /**
     * Método para verificar as credenciais do usuário.
     *
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return true se as credenciais forem válidas, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "'"; /*8*/
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome"); }
        } catch (Exception e) { }
        return result;}
}
