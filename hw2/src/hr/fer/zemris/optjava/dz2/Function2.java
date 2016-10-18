package hr.fer.zemris.optjava.dz2;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class Function2 implements IHFunction {

	private static final int BROJ_VARIJABLI = 2;
	
	@Override
	public int vratiBrojVarijabli() {
		return BROJ_VARIJABLI;
	}

	@Override
	public double vratiVrijednostU(RealVector vektor) {
		double[] x = vektor.toArray();
		return (x[0] - 1)*(x[0] - 1) + 10*(x[1] - 2)*(x[1] - 2);
	}

	@Override
	public RealVector vratiVrijednostGradijentaU(RealVector vector) {
		double[] x = vector.toArray();
		double[] gradijent = new double[BROJ_VARIJABLI];
		
		gradijent[0] = 2*(x[0] - 1);
		gradijent[1] = 20*(x[1] - 2);
		
		return new ArrayRealVector(gradijent);
	}

	@Override
	public RealMatrix vratiVrijednostHesseoveMatriceU(RealVector vektor) {
		double[][] hessian = new double[BROJ_VARIJABLI][BROJ_VARIJABLI];
		
		hessian[0][0] = 2;
		hessian[0][1] = 0;
		hessian[1][0] = 20;
		hessian[1][1] = 0;
		
		return new Array2DRowRealMatrix(hessian);
	}

}
