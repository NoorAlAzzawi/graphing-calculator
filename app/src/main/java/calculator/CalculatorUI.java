package calculator;

import javax.swing.*;
import java.awt.*;

import calculator.panels.*;
import calculator.utilities.OperatorHandler;

// CalcuUI Cleanup

public class CalculatorUI extends JFrame {

	private static final String VERSION = "0.5";
	private static final int WIDTH = 740;
	private static final int HEIGHT = 502; // With Dimension with no Graph

	private Calculator calculator;
	private OperatorHandler operatorHandler;

	private JPanel appPanel;

	public CalculatorUI(Calculator calculator) {
		this.calculator = calculator;
		initUI();
		setFrameProperties();
	}

	private void setFrameProperties() {
		setTitle(String.format("Graphing Calculator v.%s", VERSION));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(WIDTH, HEIGHT); // With Dimension with no Graph
		setLocationRelativeTo(null); // Center the window
		setVisible(true);
		setResizable(false);// set true for debugg else should be false

	}

	private void initUI() {
		// The Main Panel
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // westeros :P
		this.appPanel = mainPanel;
		setupPanels(mainPanel); // in charge of putting everything in ther place
		addPadding(mainPanel);

	}

	private DisplayPanel getDisplayPanel() {
		DisplayPanel displayPanel = new DisplayPanel();// (calcualtor)
		operatorHandler = new OperatorHandler(displayPanel.getDisplay());//
		return displayPanel;
	}

	private void addPadding(JPanel mainPanel) {
		JPanel paddedMainPanel = new JPanel(new BorderLayout());
		paddedMainPanel.add(mainPanel, BorderLayout.CENTER);
		paddedMainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setContentPane(paddedMainPanel);
	}

	private void setupPanels(JPanel mainPanel) {
		// Sub Region Panels (nested inside border layout regions)
		JPanel topRegionPanel = new JPanel(new BorderLayout(10, 10));
		JPanel leftRegionPanel = new JPanel(new BorderLayout());
		JPanel centerRegionPanel = new JPanel(new BorderLayout());
		JPanel rightRegionPanel = new JPanel(new BorderLayout(5, 10));

		// DisplayPanel (lives in the north)
		DisplayPanel displayPanel = getDisplayPanel();

		// MiscPanel (lives in the east)
		MiscOpPanel miscOpPanel = new MiscOpPanel(calculator, displayPanel, operatorHandler);

		// BinaryPanel (lives in the east)
		BinaryOpPanel binaryPanel = new BinaryOpPanel(centerRegionPanel, operatorHandler);

		// UnaryPanel (livesin the east, east to the binary panel)
		UnaryOpPanel unaryPanel = new UnaryOpPanel(calculator, displayPanel, binaryPanel, operatorHandler);

		// NumberPanel (lives in the center of the world)
		NumberKeyPanel numberPanel = new NumberKeyPanel(operatorHandler);

		// TrigPanel (lives in the west alone)
		TrigOpPanel trigPanel = new TrigOpPanel(calculator, displayPanel, operatorHandler);// (calculator,displayPanel)

		//// drawing component

		// Add Operator Panels to their subregions
		// NOTE to Me: this works but might not be the most efficient, but no more time
		// to fiddle with UIlayout
		mainPanel.add(topRegionPanel, BorderLayout.NORTH);
		mainPanel.add(leftRegionPanel, BorderLayout.WEST);
		mainPanel.add(centerRegionPanel, BorderLayout.CENTER);
		mainPanel.add(rightRegionPanel, BorderLayout.EAST);

		// Add panels to regions
		topRegionPanel.add(displayPanel, BorderLayout.EAST);// right side
		topRegionPanel.add(miscOpPanel, BorderLayout.WEST);
		leftRegionPanel.add(trigPanel, BorderLayout.WEST);
		centerRegionPanel.add(numberPanel);
		rightRegionPanel.add(binaryPanel, BorderLayout.WEST);
		rightRegionPanel.add(unaryPanel, BorderLayout.EAST);

		// mainPanel.add(downRegionPanel, BorderLayout.SOUTH); // uncoment to make graph
		// region visible
		// downRegionPanel.add(graphPanel, BorderLayout.SOUTH); // uncoment to make
		// graph region visible
	}
	public JPanel getAppPanel() {
		return this.appPanel;
	}
	
}