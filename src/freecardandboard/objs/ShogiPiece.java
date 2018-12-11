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

import freecardandboard.enums.ShogiPieceColor;
import freecardandboard.enums.ShogiPieceType;

/**
 *
 * @author Jeffrey Hope
 */
public class ShogiPiece extends ChessVarPiece {
    private final ShogiPieceColor PIECE_COLOR;
    private final ShogiPieceType PIECE_TYPE;
    
    public ShogiPiece(ShogiPieceColor pieceColor, ShogiPieceType pieceType) {
        PIECE_COLOR = pieceColor;
        PIECE_TYPE = pieceType;
    } 
    
    public ShogiPieceColor getPieceColor() {
        return PIECE_COLOR;
    }
    
    public ShogiPieceType getPieceType() {
        return PIECE_TYPE;
    }
    
    public String getAbbreviation() {
        switch (PIECE_COLOR) {
            case SENTE: return PIECE_TYPE.getAbbrev().toUpperCase();
            default: return PIECE_TYPE.getAbbrev().toLowerCase();
        }
    }
}
