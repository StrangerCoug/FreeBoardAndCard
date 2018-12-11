/*
 * Copyright (c) 2018, Jeffrey Hope
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package freecardandboard.objs;

import freecardandboard.enums.ChessPieceColor;

/**
 *
 * @author Jeffrey Hope
 */
public class Chess480Board extends Chess960Board {

    /**
     * While this method has a self-explanatory name, it does not check if the
     * castle is legal and does not itself check if the king moves "off the 
     * board" during the castle (although doing that throws an
     * IndexOutOfBoundsException).
     * 
     * @param player the player castling
     * @param kingside true for a kingside castle, false for a queenside castle
     */
    @Override
    public void castle(ChessPieceColor player, boolean kingside) {
        byte startRank;
        switch (player) {
            case WHITE: startRank = 0;
                break;
            case BLACK: startRank = 7;
                break;
            default: throw new NullPointerException();
        }
        
        if (kingside) {
            movePiece(new int[]{kingFile,startRank}, new int[]{kingFile+2,
                startRank});
            movePiece(new int[]{kingRookFile,startRank}, new int[]{kingFile+1,
                startRank});
        }
        else {
            movePiece(new int[]{kingFile,startRank}, new int[]{kingFile-2,
                startRank});
            movePiece(new int[]{queenRookFile,startRank}, new int[]{kingFile-1,
                startRank});
        }
    }
}
