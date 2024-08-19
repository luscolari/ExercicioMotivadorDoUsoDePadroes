public class App {
    public static void main(String[] args) throws Exception {
        Motor FLEX;

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
    
        //Criação de carro esportivo que utiliza gasolina, consome 6 km/it e tem capacidade 45 litros.
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45);

        //Criação de carro UTILIÁRIO que utiliza diesel, consome 5 km/it e tem capacidade 70 litros.
        //Aqui foi necessário atualizar a classe TipoCombustivel.java para aceitar o Diesel.
        Carro utilitario = new Carro("Utilitário", TipoCombustivel.DIESEL, 5, 70);

        //Criação de carro SUV que utiliza gasolina, consome 8 km/it e tem capacidade 55 litros.
        //Para o carro ser FLEX, em construtor na classe "Carro" foi criado um novo construtor para 
        // adicionar o tipo do motor.
        Carro SUV = new Carro("SUV", TipoCombustivel.GASOLINA, 8, 55, true);
        
        //Criação de carro SUVFlex que utiliza tanto gasolina como alcool (então é flex), quando usa 
        //gasolina consome 8 km/it e quando usa álcool consumo 6km/it e o tanque é FLex e tem 65 litros de capacidade.
        //Para o carro ser FLEX, em construtor na classe "Carro"foi criado um novo construtor para 
        // adicionar o tipo do tanque.
        Carro SUVFlex = new Carro("SUV Flex", TipoCombustivel.FLEX, 8, 6, 65);
    
        //Criação de carro SUVFlex que utiliza gasolina, consome 0 Km/lt, porém este consumo reduz 
        // 1 Km/lt a cada 5000 Km até que se estabiliza em 10 Km/lt. 
        //Para o carro ter essa redução, um construtor na classe "Motor" foi criado um novo construtor para 
        //poder fazer a lógica da redução.
        Carro Econo = new Carro("Econo", TipoCombustivel.GASOLINA, 20, 55);

        System.out.println("Tipos de veiculos:");
        System.out.println(basico);

        //Adição do carro esportivo em tipos de veículos
        System.out.println(esportivo);

        //Adição do carro esportivo em tipos de veículos
        System.out.print(utilitario);

        //Adição do carro SUV em tipos de veículos
        System.out.println(SUV);

        //Adição do carro SUVFlex em tipos de veículos
        System.out.println(SUVFlex);

        System.out.println(Econo);

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
