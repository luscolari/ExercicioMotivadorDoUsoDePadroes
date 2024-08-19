public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;
    private int consumoMinimo;
    private boolean flex;

    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    // Construtor para carro com Motor FLEX.
    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumo, int capacidadeTanque, boolean flex) {
        this.modelo = modelo;
        this.motor = new Motor(tipoCombustivel, consumo);
        this.tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
        this.flex = flex;
    }

    // Construtor para motores FLEX com consumo específico para gasolina e álcool
    public Carro(String modelo, int consumoMotorGasolina, int consumoMotorAlcool, int capacidadeTanque) {
        this.modelo = modelo;
        this.motor = new Motor(consumoMotorGasolina, consumoMotorAlcool);
        this.tanque = new TanqueCombustivel(TipoCombustivel.FLEX, capacidadeTanque); // Assumindo tanque FLEX
    }


    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumo, int consumoMinimo, int capacidadeTanque) {
        this.modelo = modelo;
        this.motor = new Motor(tipoCombustivel, consumo, consumoMinimo);
        this.tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = motor.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(motor.combustivelNecessario(distancia));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
