package com.sanmukh.tictactoe;

import java.io.Serializable;
import java.util.Arrays;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class Board implements Serializable {

  @NonNull
  private final String id;

  public Board(@NonNull String id){
    this.id = id;
  }

  public BoardMarkType getMarkAtPosition(){

  }
  public enum BoardMarkType{
    X, O;
  }
  @RequiredArgsConstructor
  public enum BoardPosition {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    @NonNull
    private final Integer positionNum;

    @Override
    public String toString(){
      return String.valueOf(this.positionNum);
    }

    public BoardPosition valueOf(int position) {
      return Arrays.stream(BoardPosition.values()).filter(p -> p.positionNum == position).findFirst().orElseThrow(
          () -> {
            throw new IllegalArgumentException("Position not valid : " + position);
          });
    }
  }

}
