package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Estado;
import model.FuncionTransicion;

public class PanelGrafo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Estado> estados;

	public PanelGrafo(ArrayList<Estado> arrayList) {
		this.estados = arrayList;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int x = 100; int y = 30;
		for (Estado estado : estados) {
			
			for (FuncionTransicion t : estado.getTranciociones()) {
				g.drawString(""+t.getLetter(), x+75,y);
				g.drawLine(x, y+25, x+100, y+25);
			}
			
			if (estado.isInitial()) {
				g.setColor(Color.CYAN);
			}else if (estado.isFinal()) {
				g.setColor(Color.ORANGE);
			}else {
				g.setColor(Color.YELLOW);
				
			}
			g.fillOval(x, y, 50, 50);
			g.setColor(Color.BLACK);
			g.drawString(estado.getNombre(), (x)+20, y+25);
			
			
			x+= 100;
		}
	}
	
	public void update(ArrayList<Estado> estados) {
		this.estados = estados;
		revalidate();
		repaint();
	}

}
