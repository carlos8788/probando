package Supermark;

public class Domicilio {
	private int id;
	private String calle;
	private int numero;  
	private int lote;
	private String manzana;
	private int edificio;
	private int departamento;
	private int piso;
	private int idUsuario;
    
    public Domicilio () {}
    
    public Domicilio(int id, String calle, int numero, int lote, String manzana, int edificio, int departamento, int piso, int idUsuario){
    	this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.lote = lote;
        this.manzana = manzana;
        this.edificio = edificio;
        this.departamento = departamento;
        this.piso = piso;
        this.idUsuario = idUsuario;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public String getManzana() {
		return manzana;
	}

	public void setManzana(String manzana) {
		this.manzana = manzana;
	}

	public int getEdificio() {
		return edificio;
	}

	public void setEdificio(int edificio) {
		this.edificio = edificio;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
    
	public String toString() {
        return "Domicilio: " + id + calle + numero + lote + manzana + edificio + departamento + piso;
    }
}
