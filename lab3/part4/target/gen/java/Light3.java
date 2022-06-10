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


public class Light3 extends ASTRAClass {
	public Light3() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Light3", new int[] {20,9,20,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("switch", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light3", new int[] {20,28,22,5},
				new Statement[] {
					new Subgoal(
						"Light3", new int[] {21,7,22,5},
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
			"Light3", new int[] {24,9,24,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light3", new int[] {24,26,27,5},
				new Statement[] {
					new Subgoal(
						"Light3", new int[] {25,8,27,5},
						new Goal(
							new Predicate("flash", new Term[] {
								Primitive.newPrimitive(10)
							})
						)
					),
					new ModuleCall("s",
						"Light3", new int[] {26,8,26,16},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light3","s")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Light3", new int[] {29,9,29,65},
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
				"Light3", new int[] {29,64,33,5},
				new Statement[] {
					new BeliefUpdate('-',
						"Light3", new int[] {30,6,33,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "S")
						})
					),
					new BeliefUpdate('+',
						"Light3", new int[] {31,6,33,5},
						new Predicate("light", new Term[] {
							new Variable(Type.STRING, "R")
						})
					),
					new ModuleCall("console",
						"Light3", new int[] {32,6,32,43},
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
								return ((astra.lang.Console) intention.getModule("Light3","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Light3", new int[] {35,9,35,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("light", new Term[] {
						new Variable(Type.STRING, "S",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light3", new int[] {35,27,37,5},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Light3", new int[] {39,9,39,67},
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
				"Light3", new int[] {39,66,43,5},
				new Statement[] {
					new BeliefUpdate('-',
						"Light3", new int[] {40,8,43,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "R")
						})
					),
					new BeliefUpdate('+',
						"Light3", new int[] {41,8,43,5},
						new Predicate("switch", new Term[] {
							new Variable(Type.STRING, "S")
						})
					),
					new Subgoal(
						"Light3", new int[] {42,8,43,5},
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
			"Light3", new int[] {45,9,45,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("flash", new Term[] {
						new Variable(Type.INTEGER, "N",false)
					})
				)
			),
			new Comparison("==",
				new Variable(Type.INTEGER, "N"),
				Primitive.newPrimitive(1)
			),
			new Block(
				"Light3", new int[] {45,32,50,5},
				new Statement[] {
					new Subgoal(
						"Light3", new int[] {46,8,50,5},
						new Goal(
							new Predicate("switch", new Term[] {
								Primitive.newPrimitive("on")
							})
						)
					),
					new ModuleCall("s",
						"Light3", new int[] {47,8,47,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light3","s")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Light3", new int[] {48,8,50,5},
						new Goal(
							new Predicate("switch", new Term[] {
								Primitive.newPrimitive("off")
							})
						)
					),
					new ModuleCall("s",
						"Light3", new int[] {49,8,49,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light3","s")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Light3", new int[] {52,9,52,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("flash", new Term[] {
						new Variable(Type.INTEGER, "N",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Light3", new int[] {52,24,58,5},
				new Statement[] {
					new Subgoal(
						"Light3", new int[] {53,8,58,5},
						new Goal(
							new Predicate("switch", new Term[] {
								Primitive.newPrimitive("on")
							})
						)
					),
					new ModuleCall("s",
						"Light3", new int[] {54,8,54,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light3","s")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Light3", new int[] {55,8,58,5},
						new Goal(
							new Predicate("switch", new Term[] {
								Primitive.newPrimitive("off")
							})
						)
					),
					new ModuleCall("s",
						"Light3", new int[] {56,8,56,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Light3","s")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Light3", new int[] {57,8,58,5},
						new Goal(
							new Predicate("flash", new Term[] {
								Operator.newOperator('-',
									new Variable(Type.INTEGER, "N"),
									Primitive.newPrimitive(1)
								)
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
			astra.core.Agent agent = new Light3().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
