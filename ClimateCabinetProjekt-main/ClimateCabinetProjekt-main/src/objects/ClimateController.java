package objects;

public class ClimateController {

	private double temp = 0.0;
	private double currentTemp;
	private double second;
	private double wantedTemperature;
	private int toleranceRate;

	public void setTarget(ClimateCabinet climateCabinet, double wantedTemperature, int second) {
		this.wantedTemperature = wantedTemperature;
		this.temp = (wantedTemperature - climateCabinet.currentTemp) / second;
		this.second = second;
	}

	public void operTemp() {

	}

	public double getTemp() {
		return temp;
	}

	public double getCurrentTemp() { // Mock Server
		return currentTemp;
	}

	public double getWantedTemperature() {
		return wantedTemperature;
	}

	public double getSecond() {
		return second;
	}

	public int getToleranceRate() {
		return toleranceRate;
	}

	public void setToleranceRate(int toleranceRate) {
		this.toleranceRate = toleranceRate;
	}
}
