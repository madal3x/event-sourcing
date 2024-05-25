package flight

import flight.event.Event

trait ApplyEvent[E <: Event] {
  def applyEvent(flights: Seq[Flight], event: E): Seq[Flight]
}
