package Logic;

public class Auftrag extends Fertigungsverwaltung {
	/**
	 * @param aUFTRAG_ID
	 * @param tITEL
	 * @param aRT
	 * @param prognostizierte_kosten
	 * @param reelle_kosten
	 * @param angenommen
	 * @param gefertigt
	 * @param kalkuliert
	 * @param abgeholt
	 * @param abgerechnet
	 * @param warten
	 * @param unterbrochen
	 * @param defekt
	 */
	
	//Final?
	final private int AUFTRAG_ID;
	final private String TITEL;
	final private String ART;
	private double prognostizierte_kosten; // Vielleicht abkuerzen?
	private	double reelle_kosten;
	private	boolean angenommen;
	private	boolean gefertigt;
	private	boolean	kalkuliert;
	private	boolean	abgeholt;
	private	boolean abgerechnet;
	private	boolean warten;
	private	boolean unterbrochen;
	private	boolean defekt;
	
	public Auftrag(int aUFTRAG_ID, String tITEL, String aRT, double prognostizierte_kosten, double reelle_kosten,
			boolean angenommen, boolean gefertigt, boolean kalkuliert, boolean abgeholt, boolean abgerechnet,
			boolean warten, boolean unterbrochen, boolean defekt) {
		super();
		AUFTRAG_ID = aUFTRAG_ID;
		TITEL = tITEL;
		ART = aRT;
		this.prognostizierte_kosten = prognostizierte_kosten;
		this.reelle_kosten = reelle_kosten;
		this.angenommen = angenommen;
		this.gefertigt = gefertigt;
		this.kalkuliert = kalkuliert;
		this.abgeholt = abgeholt;
		this.abgerechnet = abgerechnet;
		this.warten = warten;
		this.unterbrochen = unterbrochen;
		this.defekt = defekt;
	}
	
	public double getPrognostizierte_kosten() {
		return prognostizierte_kosten;
	}
	public void setPrognostizierte_kosten(double prognostizierte_kosten) {
		this.prognostizierte_kosten = prognostizierte_kosten;
	}
	public double getReelle_kosten() {
		return reelle_kosten;
	}
	public void setReelle_kosten(double reelle_kosten) {
		this.reelle_kosten = reelle_kosten;
	}
	public boolean isAngenommen() {
		return angenommen;
	}
	public void setAngenommen(boolean angenommen) {
		this.angenommen = angenommen;
	}
	public boolean isGefertigt() {
		return gefertigt;
	}
	public void setGefertigt(boolean gefertigt) {
		this.gefertigt = gefertigt;
	}
	public boolean isKalkuliert() {
		return kalkuliert;
	}
	public void setKalkuliert(boolean kalkuliert) {
		this.kalkuliert = kalkuliert;
	}
	public boolean isAbgeholt() {
		return abgeholt;
	}
	public void setAbgeholt(boolean abgeholt) {
		this.abgeholt = abgeholt;
	}
	public boolean isAbgerechnet() {
		return abgerechnet;
	}
	public void setAbgerechnet(boolean abgerechnet) {
		this.abgerechnet = abgerechnet;
	}
	public boolean isWarten() {
		return warten;
	}
	public void setWarten(boolean warten) {
		this.warten = warten;
	}
	public boolean isUnterbrochen() {
		return unterbrochen;
	}
	public void setUnterbrochen(boolean unterbrochen) {
		this.unterbrochen = unterbrochen;
	}
	public boolean isDefekt() {
		return defekt;
	}
	public void setDefekt(boolean defekt) {
		this.defekt = defekt;
	}
	public int getAUFTRAG_ID() {
		return AUFTRAG_ID;
	}
	public String getTITEL() {
		return TITEL;
	}
	public String getART() {
		return ART;
	}
}
