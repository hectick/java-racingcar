package racingcar;

import java.util.function.Supplier;
import racingcar.domain.Participants;
import racingcar.domain.Round;

public class RacingManager {

  private final Participants participants;
  private final Round round;
  private final Supplier<Integer> fuel;

  public RacingManager(final Participants participants, final Round round,
      final Supplier<Integer> fuel) {
    this.participants = participants;
    this.round = round;
    this.fuel = fuel;
  }

  public RacingResult start() {
    RacingResult racingResult = new RacingResult();
    for (int i = 0; i < round.get(); i++) {
      race(racingResult, i + 1);
    }
    return racingResult;
  }

  private void race(final RacingResult racingResult, final int round) {
    participants.cars().forEach(car -> {
      car.run(fuel.get());
      racingResult.appendLog(round, car);
    });
  }

}