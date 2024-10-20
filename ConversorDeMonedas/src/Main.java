public class Main {
    public static void main(String[] args) {
        try {
            String jsonResponse = ConversorMonedas.getExchangeRates(); // Simulamos la llamada al método de la clase ConversorMonedas
            ConversorMonedas.mostrarTasasFiltradas(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
