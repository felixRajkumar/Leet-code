package Math;

class Arranging_Coins {
	public int arrangeCoins(int n) {
		return (int)(Math.sqrt(2 * (long) n + 0.25) - 0.5);
	}
}