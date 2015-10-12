package mada;

import java.math.BigInteger;

/**
 * Represents a mathematical tuple: (value1, value2).
 */
public class Tuple {

	private BigInteger firstElement;
	private BigInteger secondElement;

	public Tuple(BigInteger firstElement, BigInteger secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	public BigInteger getFirstElement() {
		return firstElement;
	}

	public void setFirstElement(BigInteger firstElement) {
		this.firstElement = firstElement;
	}

	public BigInteger getSecondElement() {
		return secondElement;
	}

	public void setSecondElement(BigInteger secondElement) {
		this.secondElement = secondElement;
	}

	public static Tuple parseTuple(String tupleString) {
		String[] parts = prepareForParsing(tupleString);
		ensureIntegrity(parts);

		BigInteger part1 = new BigInteger(parts[0]);
		BigInteger part2 = new BigInteger(parts[1]);
		Tuple tuple = new Tuple(part1, part2);
		return tuple;
	}

	public String toString() {
		return String.format("(%s,%s)", firstElement.toString(), secondElement.toString());
	}

	private static String[] prepareForParsing(String tupleString) {
		tupleString = tupleString.replaceAll("\\(", "");
		tupleString = tupleString.replaceAll("\\)", "");

		String[] parts = tupleString.split("\\,");
		return parts;
	}

	private static void ensureIntegrity(String[] parts) {
		int length = parts.length;
		if (length != 2) {
			String message = String.format("Expected 2 comma separated values but got [%s]", length);
			throw new RuntimeException(message);
		}
	}

}
