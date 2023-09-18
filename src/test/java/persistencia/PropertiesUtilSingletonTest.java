package persistencia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PropertiesUtilSingletonTest {
    
    @Test
    public void testGetDriver() {
        assertEquals("com.mysql.cj.jdbc.Driver", PropertiesUtilSingleton.getInstance().getDriver());
    }

    @Test
    public void testGetconnectionString() {
        assertEquals("jdbc:mysql://10.88.6.66:3306/RESISTENCIA?useSSL=false", PropertiesUtilSingleton.getInstance().getconnectionString());
    }

    @Test
    public void testGetdatabasePass() {
        assertEquals("078907", PropertiesUtilSingleton.getInstance().getdatabasePass());
    }

    @Test
    public void testGetdatabasesUser() {
        assertEquals("root", PropertiesUtilSingleton.getInstance().getdatabaseUser());
    }
}
