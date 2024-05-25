package flight

import flight.event.Event

trait ApplyEvents {
  def applyEvents[E <: Event : ApplyEvent](flights: Seq[Flight], events: Seq[E])
                                          (implicit applyEvent: ApplyEvent[E]): Seq[Flight] =
  {
    events.foldLeft(flights) { (flights, event) =>
      applyEvent.applyEvent(flights, event)
    }
  }
}

object ApplyEvents extends ApplyEvents
