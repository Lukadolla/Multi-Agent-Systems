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


public class Light extends ASTRAClass {
	public Light() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Light", new int[] {18,9,18,28},
			new BeliefEvent('+',
				new Predicate("switch", new Term[] {
					new Variable(Type.STRING, "S",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Light", new int[] {18,27,20,5},
				new Statement[] {
					new Subgoal(
						"Light", new int[] {19,7,20,5},
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
			"Light", new int[] {22,9,22,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light", new int[] {22,26,31,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Light", new int[] {23,8,31,5},
						new Predicate("switch", new Term[] {
							Primitive.newPrimitive("on")
						})
					),
					new Wait(
						"Light", new int[] {24,8,31,5},
						new Predicate("light", new Term[] {
							Primitive.newPrimitive("on")
						})
					),
					new BeliefUpdate('+',
						"Light", new int[] {26,8,31,5},
						new Predicate("switch", new Term[] {
							Primitive.newPrimitive("off")
						})
					),
					new Wait(
						"Light", new int[] {27,8,31,5},
						new Predicate("light", new Term[] {
							Primitive.newPrimitive("off")
						})
					),
					new ModuleCall("s",
						"Light", new int[] {28,8,28,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light","s")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("s",
						"Light", new int[] {30,8,30,16},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light","s")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Light", new int[] {33,9,33,65},
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
				"Light", new int[] {33,64,38,5},
				new Statement[] {
					new BeliefUpdate('-',
						"Light", new int[] {34,6,38,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "S")
						})
					),
					new BeliefUpdate('-',
						"Light", new int[] {35,6,38,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "S")
						})
					),
					new BeliefUpdate('+',
						"Light", new int[] {36,6,38,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "R")
						})
					),
					new ModuleCall("console",
						"Light", new int[] {37,6,37,43},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("The light is: "),
								new Variable(Type.STRING, "R")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Light","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Light", new int[] {40,9,40,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light", new int[] {40,27,42,5},
				new Statement[] {
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("switch", new Term[] {
				Primitive.newPrimitive("on")
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
			astra.core.Agent agent = new Light().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
