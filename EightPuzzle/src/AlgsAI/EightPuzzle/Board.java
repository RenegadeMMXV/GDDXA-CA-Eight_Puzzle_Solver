/**
 *	@author			Ciaran Bent [K00221230]
 *	@creationDate	2018/12/20
 *	@description	...
 *
 */

package AlgsAI.EightPuzzle;

//import

public class Board {
    private int m_order;
    int[] m_tiles;
    private int m_invers;
    private int m_zeRow;

    /**
     *	@desc	Board Object Constructor
     *	@param	tiles	- Two-Dimensional Array of Int values that holds the
     *                 	  default configuration of the Board.
     *	@funct	hamming     - Return count of out-of-place blocks.
     *          manhattan   - Return Manhattan distance to Goal State.
     *          equals      - Return Boolean for Board equality check.
     *          neighbours  - Return iterable of neighbouring Boards.
     *          toString    - Return Board String representation.
     *          inversions  - Return the number of Inversions of the Board.
     *          zeroRow     - Return the Board row containing a 0.
     */
    Board(int N, int [][] tiles) {
        this.m_order = N;
        this.m_tiles = new int[tiles.length * tiles.length];
        this.m_invers = Integer.MIN_VALUE;
        this.m_zeRow = Integer.MIN_VALUE;

        int z = 0;
        for (int[] i : tiles) {
            for (int j : i) {
                this.m_tiles[z++] = j;
                //System.out.print(m_tiles[z - 1] + "\t");
            }
            //System.out.println();
        }
    }

    /**
     *	@desc	Return count of out-of-place blocks.
     */
    public int hamming() {
        // YOUR CODE HERE
        return(Integer.MIN_VALUE);
    }

    /**
     *	@desc	Return Manhattan distance to Goal State.
     */
    public int manhattan() {
        // YOUR CODE HERE
        return(Integer.MIN_VALUE);
    }

    /**
     *	@desc	Compares this Board to another Board to check for equality.
     *	@param	o	- A Board to check against this Board.
     */
    public boolean equals(Board o) {
        boolean valid = true;

        for (int i = 0; i < m_tiles.length; i++) {
            if(this.m_tiles[i] != o.m_tiles[i]) {
                valid = false;
            }
        }

        return(valid);
    }

    /**
     *	@desc	Return iterable of neighbouring Boards.
     */
    public Iterable<Board> neighbours() {
        // YOUR CODE HERE
        return(null);
    }

    /**
     *	@desc	Return Board String representation.
     */
    public String toString() {StringBuffer temp = new StringBuffer();
        for (int i = 0; i < this.m_tiles.length;) {
            for (int j = 0; j < this.m_order; j++) {
                temp.append(this.m_tiles[i++] + "\t");
            }
            temp.append("\n");
        }

        return(temp.toString());
    }

    /**
     *	@desc	Return the number of Inversions of the Board.
     */
    public int inversions() {
        if(this.m_invers == Integer.MIN_VALUE) {
            this.m_invers = 0;
            for (int i = 0; i < this.m_tiles.length; i++) {
                int added = 0;
                for (int j = i + 1; j < this.m_tiles.length; j++) {
                    if(this.m_tiles[j] != 0 && this.m_tiles[i] != 0) {
                        if (this.m_tiles[j] < this.m_tiles[i]) {
                            //this.m_invers++;
                            added++;
                        }
                    }
                }
                this.m_invers += added;
                //System.out.println("Inversions @ " + i + ": " + added);
            }
        //System.out.println("Total Inversions: " + this.m_invers);
        }
        return(this.m_invers);
    }

    /**
     *	@desc	Return the Board row containing a '0'.
     */
    public int zeroRow() {
        if(this.m_zeRow == Integer.MIN_VALUE) {
            this.m_zeRow = 0;
            for (int i = this.m_tiles.length - 1; i > 0; i--) {
                //this.m_zeRow++;
                if (this.m_tiles[i] == 0) {
                    this.m_zeRow = Math.abs((int)Math.ceil((double)i
                                / (double)this.m_order) - this.m_order);
                }
            }
        //System.out.println("Zero @ row: " + this.m_zeRow + " from bottom");
        }

        return(this.m_zeRow + 1);
    }
}