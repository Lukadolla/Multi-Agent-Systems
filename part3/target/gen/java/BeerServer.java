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


public class BeerServer extends ASTRAClass {
	public BeerServer() {
		setParents(new Class[] {BeerOntology.class});
		addRule(new Rule(
			"BeerServer", new int[] {11,7,11,56},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("get", new Term[] {
					new Variable(Type.STRING, "X",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"BeerServer", new int[] {11,55,24,3},
				new Statement[] {
					new If(
						"BeerServer", new int[] {12,4,24,3},
						new NOT(
							new Predicate("has", new Term[] {
								new Variable(Type.STRING, "X")
							})
						),
						new Send("BeerServer", new int[] {12,17,12,46},
							new Performative("failure"),
							new Variable(Type.STRING, "sender"),
							new Predicate("get", new Term[] {
								new Variable(Type.STRING, "X")
							})
						),
						new Block(
							"BeerServer", new int[] {13,9,24,3},
							new Statement[] {
								new Send("BeerServer", new int[] {14,6,14,33},
									new Performative("agree"),
									new Variable(Type.STRING, "sender"),
									new Predicate("get", new Term[] {
										new Variable(Type.STRING, "X")
									})
								),
								new TryRecover(
									"BeerServer", new int[] {16,6,23,5},
									new Block(
										"BeerServer", new int[] {16,10,20,7},
										new Statement[] {
											new Subgoal(
												"BeerServer", new int[] {17,8,20,7},
												new Goal(
													new Predicate("get", new Term[] {
														new Variable(Type.STRING, "X")
													})
												)
											),
											new Subgoal(
												"BeerServer", new int[] {18,8,20,7},
												new Goal(
													new Predicate("deliver", new Term[] {
														new Variable(Type.STRING, "X"),
														new Variable(Type.STRING, "sender")
													})
												)
											),
											new Send("BeerServer", new int[] {19,8,19,36},
												new Performative("inform"),
												new Variable(Type.STRING, "sender"),
												new Predicate("got", new Term[] {
													new Variable(Type.STRING, "X")
												})
											)
										}
									),
									new Block(
										"BeerServer", new int[] {20,16,23,5},
										new Statement[] {
											new Send("BeerServer", new int[] {21,8,21,37},
												new Performative("failure"),
												new Variable(Type.STRING, "sender"),
												new Predicate("get", new Term[] {
													new Variable(Type.STRING, "X")
												})
											)
										}
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"BeerServer", new int[] {26,7,26,24},
			new GoalEvent('+',
				new Goal(
					new Predicate("get", new Term[] {
						new Variable(Type.STRING, "X",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"BeerServer", new int[] {26,23,28,3},
				new Statement[] {
					new ModuleCall("C",
						"BeerServer", new int[] {27,6,27,27},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Got "),
								new Variable(Type.STRING, "X")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("BeerServer","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"BeerServer", new int[] {30,7,30,43},
			new GoalEvent('+',
				new Goal(
					new Predicate("deliver", new Term[] {
						new Variable(Type.STRING, "X",false),
						new Variable(Type.STRING, "sender",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"BeerServer", new int[] {30,42,32,3},
				new Statement[] {
					new ModuleCall("C",
						"BeerServer", new int[] {31,6,31,53},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Delivered: "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "X"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" to: "),
										new Variable(Type.STRING, "sender")
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("BeerServer","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("has", new Term[] {
				Primitive.newPrimitive("Beer")
			})
		);
		agent.initialize(
			new Predicate("has", new Term[] {
				Primitive.newPrimitive("Coffee")
			})
		);
		agent.initialize(
			new Predicate("has", new Term[] {
				Primitive.newPrimitive("Monster Energy Drink TM")
			})
		);
		agent.initialize(
			new Predicate("has", new Term[] {
				Primitive.newPrimitive("Bepis")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
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
			astra.core.Agent agent = new BeerServer().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
