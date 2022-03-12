extern crate jni;

use jni::JNIEnv;
use jni::objects::{JClass, JString};
use jni::sys::jstring;

#[no_mangle]
pub extern "system" fn Java_com_github_nthily_library_Library_getStrFromRust(
    env: JNIEnv,
    _class: JClass,
    input: JString
) -> jstring {
    let input: String = env.get_string(input).unwrap().into();
    let output = env.new_string(format!("[rust]: {}", input))
        .expect("couldn't create java string!");

    return output.into_inner();
}

#[test]
fn test() {
    println!("[rust] Hello World!");
}
