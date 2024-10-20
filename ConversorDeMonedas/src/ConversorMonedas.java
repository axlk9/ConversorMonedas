import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMonedas {

    // Método para obtener la tasa de cambio de una moneda específica
    public static void obtenerTasaDeCambio(String jsonResponse, String moneda) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        double tasa = conversionRates.get(moneda).getAsDouble();
        // Usando String.format para optimizar el formato del mensaje
        System.out.println(String.format("Tasa de cambio para %s: %.2f", moneda, tasa));
    }

    // Método para filtrar y mostrar las tasas de cambio de las monedas de interés
    public static void mostrarTasasFiltradas(String jsonResponse) {
        String[] monedas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};
        for (String moneda : monedas) {
            obtenerTasaDeCambio(jsonResponse, moneda);
        }
    }

    // Método para obtener los datos de la API
    public static String getExchangeRates() throws Exception {
        String API_KEY = "4b62cfa211a2e4cd23739ae9";
        String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

        URL url = new URL(API_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        return content.toString();
    }
}
