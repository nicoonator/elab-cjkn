package Logic;

import java.util.Date;
import java.util.List;

public class Mitglied extends Person {

	@SuppressWarnings("unused")
	private final boolean admin = true;
	/**
	 * @param pERSON_ID
	 * @param vorname
	 * @param nachname
	 * @param strasse
	 * @param hausnr
	 * @param pLZ
	 * @param email
	 * @param zuerst_erstellt
	 * @param zuletzt_geaendert
	 * @param nutzername
	 * @param passwort
	 * @param bauteilschulden
	 * @param bauteilwarenkorb
	 * @param admin
	 */
	public Mitglied(int pERSON_ID, String vorname, String nachname, String strasse, String hausnr, int pLZ, String email,
			Date zuerst_erstellt, Date zuletzt_geaendert, String nutzername, String passwort, double bauteilschulden,
			List<Bauteil> bauteilwarenkorb, boolean admin, String telefonnummer) {
		super(pERSON_ID, vorname, nachname, strasse, hausnr, pLZ, email, zuerst_erstellt, zuletzt_geaendert, nutzername,
				passwort, bauteilschulden, bauteilwarenkorb, admin, telefonnummer);
		
	}
	
}
