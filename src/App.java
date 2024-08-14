public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
    
        //Criação de carro esportivo que utiliza gasolina, consome 6 km/it e tem capacidade 45 litros.
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45);

        //Criação de carro UTILIÁRIO que utiliza diesel, consome 5 km/it e tem capacidade 70 litros.
        Carro utilitario = new Carro("Utilitário", TipoCombustivel.DIESEL, 5, 70);
        System.out.println("Tipos de veiculos:");
        System.out.println(basico);

        //Adição do carro esportivo em tipos de veículos
        System.out.println(esportivo);

        //Adição do carro esportivo em tipos de veículos
        System.out.print(utilitario);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);
    }
}
