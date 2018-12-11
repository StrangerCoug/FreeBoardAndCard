/*
 * Copyright (c) 2017, Jeffrey Hope <strangercoug@hotmail.com>
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
package freecardandboard.games.board;

import freecardandboard.objs.ChessBoard;
import freecardandboard.games.board.BoardGame;
import freecardandboard.Player;
import java.util.ArrayList;

/**
 *
 * @author Jeffrey Hope <strangercoug@hotmail.com>
 */
public class Chess extends BoardGame {
    ArrayList players;
    ChessBoard board;
    
    @Override
    public void play(ArrayList<Player> players) {
        /* Throw an error if the game isn't intended for the number of players
         * it is given. */
        if (players.size() != 2)
            throw new IllegalArgumentException("You tried to start a game of " +
                    "chess with " + players.size() + " players. The game " +
                    "requires 2 players.");
        this.players = players;
        
        board = new ChessBoard();
        board.initBoard();
        System.out.println(board.toString());
    }
}
