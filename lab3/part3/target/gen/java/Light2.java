/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class Light2 extends ASTRAClass {
	public Light2() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Light2", new int[] {19,9,19,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("switch", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light2", new int[] {19,28,21,5},
				new Statement[] {
					new Subgoal(
						"Light2", new int[] {20,7,21,5},
						new Goal(
							new Predicate("light", new Term[] {
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Light2", new int[] {23,9,23,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light2", new int[] {23,26,26,5},
				new Statement[] {
					new Subgoal(
						"Light2", new int[] {24,8,26,5},
						new Goal(
							new Predicate("switch", new Term[] {
								Primitive.newPrimitive("on")
							})
						)
					),
					new ModuleCall("s",
						"Light2", new int[] {25,8,25,16},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light2","s")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Light2", new int[] {28,9,28,65},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "R",false)
					})
				)
			),
			new AND(
				new Predicate("light", new Term[] {
					new Variable(Type.STRING, "S",false)
				}),
				new Predicate("transition", new Term[] {
					new Variable(Type.STRING, "S"),
					new Variable(Type.STRING, "R")
				})
			),
			new Block(
				"Light2", new int[] {28,64,32,5},
				new Statement[] {
					new BeliefUpdate('-',
						"Light2", new int[] {29,6,32,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "S")
						})
					),
					new BeliefUpdate('+',
						"Light2", new int[] {30,6,32,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "R")
						})
					),
					new ModuleCall("console",
						"Light2", new int[] {31,6,31,43},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("The Light is: "),
								new Variable(Type.STRING, "R")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Light2","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Light2", new int[] {34,9,34,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light2", new int[] {34,27,36,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Light2", new int[] {38,9,38,67},
			new GoalEvent('+',
				new Goal(
					new Predicate("switch", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			new AND(
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "R",false)
				}),
				new Predicate("transition", new Term[] {
					new Variable(Type.STRING, "R"),
					new Variable(Type.STRING, "S")
				})
			),
			new Block(
				"Light2", new int[] {38,66,42,5},
				new Statement[] {
					new BeliefUpdate('-',
						"Light2", new int[] {39,8,42,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "R")
						})
					),
					new BeliefUpdate('+',
						"Light2", new int[] {40,8,42,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "S")
						})
					),
					new Subgoal(
						"Light2", new int[] {41,8,42,5},
						new Goal(
							new Predicate("light", new Term[] {
								new Variable(Type.STRING, "S")
							})
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("switch", new Term[] {
				Primitive.newPrimitive("off")
			})
		);
		agent.initialize(
			new Predicate("light", new Term[] {
				Primitive.newPrimitive("off")
			})
		);
		agent.initialize(
			new Predicate("transition", new Term[] {
				Primitive.newPrimitive("off"),
				Primitive.newPrimitive("on")
			})
		);
		agent.initialize(
			new Predicate("transition", new Term[] {
				Primitive.newPrimitive("on"),
				Primitive.newPrimitive("off")
			})
		);
		agent.initialize(
			new Goal(
				new Predicate("switch", new Term[] {
					Primitive.newPrimitive("on")
				})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("d",astra.lang.Debug.class,agent);
		fragment.addModule("s",astra.lang.System.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Light2().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
