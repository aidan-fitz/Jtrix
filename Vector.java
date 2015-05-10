public class Vector {

	private double[] values;

	public Vector(double... v) {
		values = v;
	}

	public int dimension() {
		return values.length;
	}

	public Vector add(Vector v) {
		// if they're not the same length, pretend missing components are zeros
	    if (v.dimension() <= this.dimension()) {
			double[] sum = new double[dimension()];
			// load the new vector
			for (int i = 0; i < v.dimension(); i++) {
				sum[i] = values[i] + v.values[i];
			}
			for (int i = v.dimension(); i < this.dimension(); i++) {
				sum[i] = values[i];
			}
			return new Vector(sum);
		}
		else {
			return v.add(this);
		}
	}

	public Vector subtract(Vector v) {
		return add(v.negate());
	}

	public Vector mult(double a) {
		double[] prod = new double[dimension()];
		for (int i = 0; i < dimension(); i++) {
			prod[i] = a*values[i];
		}
		return new Vector(prod);
	}

	public Vector negate() {
		return mult(-1);
	}

	public double dot(Vector v) {
		double prod = 0.0;
		for (int i = 0; i < this.dimension() && i < v.dimension(); i++) {
			prod += values[i] * v.values[i];
		}
		return prod;
	}

	public double magSq() {
		return dot(this);
	}

	public double mag() {
		return Math.sqrt(magSq());
	}
}
