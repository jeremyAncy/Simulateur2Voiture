package AppliSimu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;
    private double x =200;
    private double y =300;
    private double radianConvert = 0.0174532925;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture) {
		super();
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
        double d = maVoiture.getDegres();
		contexteGraphique.fillRect(xPixel, 300, 30, 15);
        //contexteGraphique.drawLine(100,300, (int) x, (int) y);
        /*x = 200 * Math.cos(d*radianConvert);
        y = 300 * Math.sin(d * radianConvert);*/
	}
	
}
